/*
 *                    BioJava development code
 *
 * This code may be freely distributed and modified under the
 * terms of the GNU Lesser General Public Licence.  This should
 * be distributed with the code.  If you do not have a copy,
 * see:
 *
 *      http://www.gnu.org/copyleft/lesser.html
 *
 * Copyright for this code is held jointly by the individual
 * authors.  These should be listed in @author doc comments.
 *
 * For more information on the BioJava project and its aims,
 * or to join the biojava-l mailing list, visit the home page
 * at:
 *
 *      http://www.biojava.org/
 *
 */
package org.biojava.nbio.structure.align.multiple;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.vecmath.Matrix4d;

/**
 * A general implementation of a BlockSet to store a flexible part of a multiple
 * alignment.
 *
 * @author Aleix Lafita
 * @since 4.1.0
 */
public class BlockSetImpl extends AbstractScoresCache implements Serializable, BlockSet, Cloneable {

    private static final long serialVersionUID = -1015791986000076089L;

    // Member variables
    private MultipleAlignment parent;

    private List<Block> blocks;

    // Cache variables (can be updated)
    // Transformation matrices
    private List<Matrix4d> pose;

    private int length;

    private int coreLength;

    private List<Integer> alignResCounts;

    /**
     *  Constructor. Links also the parent to this instance by adding the
     *  BlockSet to the parent's List.
     *
     *  @param alignment
     *             MultipleAlignment parent of the BlockSet.
     *  @return BlockSet an instance linked to the parent alignment.
     */
    public BlockSetImpl(MultipleAlignment alignment) {
        parent = alignment;
        if (parent != null)
            parent.getBlockSets().add(this);
        blocks = null;
        pose = null;
        // Value -1 reserved to indicate that has to be calculated
        length = -1;
        coreLength = -1;
        // Value null means not yet calculated
        alignResCounts = null;
    }

    /**
     *  Copy constructor. Makes also a deep copy of all constituent {@link Block}
     *  s.
     *
     *  @param bs
     *             BlockSet object to be copied.
     *  @return BlockSet an identical copy of the input object.
     */
    public BlockSetImpl(BlockSetImpl bs) {
        // This copies the cached scores
        super(bs);
        this.parent = bs.parent;
        this.length = bs.length;
        this.coreLength = bs.coreLength;
        this.pose = null;
        if (bs.pose != null) {
            // Make a deep copy of everything
            this.pose = new org.eclipse.collections.impl.list.mutable.FastList<Matrix4d>();
            for (Matrix4d trans : bs.pose) {
                Matrix4d newTrans = (Matrix4d) trans.clone();
                pose.add(newTrans);
            }
        }
        blocks = null;
        if (bs.blocks != null) {
            // Make a deep copy of everything
            this.blocks = new org.eclipse.collections.impl.list.mutable.FastList<Block>();
            for (Block b : bs.blocks) {
                Block newB = b.clone();
                newB.setBlockSet(this);
                this.blocks.add(newB);
            }
        }
    }

    @Override
    public void clear() {
        super.clear();
        length = -1;
        coreLength = -1;
        alignResCounts = null;
        pose = null;
        for (Block a : getBlocks()) {
            a.clear();
        }
    }

    @Override
    public BlockSetImpl clone() {
        return new BlockSetImpl(this);
    }

    @Override
    public String toString() {
        return "BlockSetImpl [blocks=" + blocks + ", pose=" + pose + ", length=" + length + ", coreLength=" + coreLength + "]";
    }

    @Override
    public MultipleAlignment getMultipleAlignment() {
        return parent;
    }

    @Override
    public void setMultipleAlignment(MultipleAlignment parent) {
        this.parent = parent;
    }

    @Override
    public List<Block> getBlocks() {
        if (blocks == null)
            blocks = new org.eclipse.collections.impl.list.mutable.FastList<Block>();
        return blocks;
    }

    @Override
    public void setBlocks(List<Block> blocks) {
        this.blocks = blocks;
        for (Block b : blocks) {
            b.setBlockSet(this);
        }
    }

    @Override
    public List<Matrix4d> getTransformations() {
        return pose;
    }

    @Override
    public void setTransformations(List<Matrix4d> transformations) {
        if (size() != transformations.size()) {
            throw new IllegalArgumentException("Wrong number of structures for this alignment");
        }
        pose = transformations;
    }

    @Override
    public int length() {
        if (length == -1)
            updateLength();
        return length;
    }

    @Override
    public int size() {
        // Get the size from the variables that can contain the information
        if (parent != null)
            return parent.size();
        else if (getBlocks().size() == 0) {
            throw new IndexOutOfBoundsException("Empty BlockSet: number of Blocks == 0.");
        } else
            return blocks.get(0).size();
    }

    @Override
    public int getCoreLength() {
        if (coreLength == -1)
            updateCoreLength();
        return coreLength;
    }

    protected void updateLength() {
        if (getBlocks().size() == 0) {
            throw new IndexOutOfBoundsException("Empty BlockSet: number of Blocks == 0.");
        } else // Try to calculate it from the Block information
        {
            length = 0;
            for (Block block : blocks) length += block.length();
        }
    }

    protected void updateCoreLength() {
        if (getBlocks().size() == 0) {
            throw new IndexOutOfBoundsException("Empty BlockSet: number of Blocks == 0.");
        } else // Try to calculate it from the Block information
        {
            coreLength = 0;
            for (Block block : blocks) coreLength += block.getCoreLength();
        }
    }

    protected void updateCache() {
        updateCoreLength();
        updateLength();
    }

    @Override
    public List<Integer> getAlignResCounts() {
        if (alignResCounts != null)
            return alignResCounts;
        alignResCounts = new ArrayList<Integer>(size());
        for (int s = 0; s < size(); s++) alignResCounts.add(0);
        for (Block b : blocks) {
            List<Integer> bcounts = b.getAlignResCounts();
            for (int s = 0; s < size(); s++) alignResCounts.set(s, alignResCounts.get(s) + bcounts.get(s));
        }
        return alignResCounts;
    }
}
