/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

// THIS CODE IS AUTOMATICALLY GENERATED.  DO NOT EDIT.

package org.apache.kafka.common.message;

import org.apache.kafka.common.errors.UnsupportedVersionException;
import org.apache.kafka.common.protocol.Message;
import org.apache.kafka.common.protocol.types.Schema;

public final class ApiMessageFactory {
    public static Message newRequest(short apiKey) {
        switch (apiKey) {
            case 0:
                return new ProduceRequestData();
            case 1:
                return new FetchRequestData();
            case 2:
                return new ListOffsetRequestData();
            case 3:
                return new MetadataRequestData();
            case 4:
                return new LeaderAndIsrRequestData();
            case 5:
                return new StopReplicaRequestData();
            case 6:
                return new UpdateMetadataRequestData();
            case 7:
                return new ControlledShutdownRequestData();
            case 8:
                return new OffsetCommitRequestData();
            case 9:
                return new OffsetFetchRequestData();
            case 10:
                return new FindCoordinatorRequestData();
            case 11:
                return new JoinGroupRequestData();
            case 12:
                return new HeartbeatRequestData();
            case 13:
                return new LeaveGroupRequestData();
            case 14:
                return new SyncGroupRequestData();
            case 15:
                return new DescribeGroupsRequestData();
            case 16:
                return new ListGroupsRequestData();
            case 17:
                return new SaslHandshakeRequestData();
            case 18:
                return new ApiVersionsRequestData();
            case 19:
                return new CreateTopicsRequestData();
            case 20:
                return new DeleteTopicsRequestData();
            case 21:
                return new DeleteRecordsRequestData();
            case 22:
                return new InitProducerIdRequestData();
            case 23:
                return new OffsetForLeaderEpochRequestData();
            case 24:
                return new AddPartitionsToTxnRequestData();
            case 25:
                return new AddOffsetsToTxnRequestData();
            case 26:
                return new EndTxnRequestData();
            case 27:
                return new WriteTxnMarkersRequestData();
            case 28:
                return new TxnOffsetCommitRequestData();
            case 29:
                return new DescribeAclsRequestData();
            case 30:
                return new CreateAclsRequestData();
            case 31:
                return new DeleteAclsRequestData();
            case 32:
                return new DescribeConfigsRequestData();
            case 33:
                return new AlterConfigsRequestData();
            case 34:
                return new AlterReplicaLogDirsRequestData();
            case 35:
                return new DescribeLogDirsRequestData();
            case 36:
                return new SaslAuthenticateRequestData();
            case 37:
                return new CreatePartitionsRequestData();
            case 38:
                return new CreateDelegationTokenRequestData();
            case 39:
                return new RenewDelegationTokenRequestData();
            case 40:
                return new ExpireDelegationTokenRequestData();
            case 41:
                return new DescribeDelegationTokenRequestData();
            case 42:
                return new DeleteGroupsRequestData();
            case 43:
                return new ElectPreferredLeadersRequestData();
            default:
                throw new UnsupportedVersionException("Unsupported request API key " + apiKey);
        }
    }
    
    public static Message newResponse(short apiKey) {
        switch (apiKey) {
            case 0:
                return new ProduceResponseData();
            case 1:
                return new FetchResponseData();
            case 2:
                return new ListOffsetResponseData();
            case 3:
                return new MetadataResponseData();
            case 4:
                return new LeaderAndIsrResponseData();
            case 5:
                return new StopReplicaResponseData();
            case 6:
                return new UpdateMetadataResponseData();
            case 7:
                return new ControlledShutdownResponseData();
            case 8:
                return new OffsetCommitResponseData();
            case 9:
                return new OffsetFetchResponseData();
            case 10:
                return new FindCoordinatorResponseData();
            case 11:
                return new JoinGroupResponseData();
            case 12:
                return new HeartbeatResponseData();
            case 13:
                return new LeaveGroupResponseData();
            case 14:
                return new SyncGroupResponseData();
            case 15:
                return new DescribeGroupsResponseData();
            case 16:
                return new ListGroupsResponseData();
            case 17:
                return new SaslHandshakeResponseData();
            case 18:
                return new ApiVersionsResponseData();
            case 19:
                return new CreateTopicsResponseData();
            case 20:
                return new DeleteTopicsResponseData();
            case 21:
                return new DeleteRecordsResponseData();
            case 22:
                return new InitProducerIdResponseData();
            case 23:
                return new OffsetForLeaderEpochResponseData();
            case 24:
                return new AddPartitionsToTxnResponseData();
            case 25:
                return new AddOffsetsToTxnResponseData();
            case 26:
                return new EndTxnResponseData();
            case 27:
                return new WriteTxnMarkersResponseData();
            case 28:
                return new TxnOffsetCommitResponseData();
            case 29:
                return new DescribeAclsResponseData();
            case 30:
                return new CreateAclsResponseData();
            case 31:
                return new DeleteAclsResponseData();
            case 32:
                return new DescribeConfigsResponseData();
            case 33:
                return new AlterConfigsResponseData();
            case 34:
                return new AlterReplicaLogDirsResponseData();
            case 35:
                return new DescribeLogDirsResponseData();
            case 36:
                return new SaslAuthenticateResponseData();
            case 37:
                return new CreatePartitionsResponseData();
            case 38:
                return new CreateDelegationTokenResponseData();
            case 39:
                return new RenewDelegationTokenResponseData();
            case 40:
                return new ExpireDelegationTokenResponseData();
            case 41:
                return new DescribeDelegationTokenResponseData();
            case 42:
                return new DeleteGroupsResponseData();
            case 43:
                return new ElectPreferredLeadersResponseData();
            default:
                throw new UnsupportedVersionException("Unsupported response API key " + apiKey);
        }
    }
    
    public static Schema[] requestSchemas(short apiKey) {
        switch (apiKey) {
            case 0:
                return ProduceRequestData.SCHEMAS;
            case 1:
                return FetchRequestData.SCHEMAS;
            case 2:
                return ListOffsetRequestData.SCHEMAS;
            case 3:
                return MetadataRequestData.SCHEMAS;
            case 4:
                return LeaderAndIsrRequestData.SCHEMAS;
            case 5:
                return StopReplicaRequestData.SCHEMAS;
            case 6:
                return UpdateMetadataRequestData.SCHEMAS;
            case 7:
                return ControlledShutdownRequestData.SCHEMAS;
            case 8:
                return OffsetCommitRequestData.SCHEMAS;
            case 9:
                return OffsetFetchRequestData.SCHEMAS;
            case 10:
                return FindCoordinatorRequestData.SCHEMAS;
            case 11:
                return JoinGroupRequestData.SCHEMAS;
            case 12:
                return HeartbeatRequestData.SCHEMAS;
            case 13:
                return LeaveGroupRequestData.SCHEMAS;
            case 14:
                return SyncGroupRequestData.SCHEMAS;
            case 15:
                return DescribeGroupsRequestData.SCHEMAS;
            case 16:
                return ListGroupsRequestData.SCHEMAS;
            case 17:
                return SaslHandshakeRequestData.SCHEMAS;
            case 18:
                return ApiVersionsRequestData.SCHEMAS;
            case 19:
                return CreateTopicsRequestData.SCHEMAS;
            case 20:
                return DeleteTopicsRequestData.SCHEMAS;
            case 21:
                return DeleteRecordsRequestData.SCHEMAS;
            case 22:
                return InitProducerIdRequestData.SCHEMAS;
            case 23:
                return OffsetForLeaderEpochRequestData.SCHEMAS;
            case 24:
                return AddPartitionsToTxnRequestData.SCHEMAS;
            case 25:
                return AddOffsetsToTxnRequestData.SCHEMAS;
            case 26:
                return EndTxnRequestData.SCHEMAS;
            case 27:
                return WriteTxnMarkersRequestData.SCHEMAS;
            case 28:
                return TxnOffsetCommitRequestData.SCHEMAS;
            case 29:
                return DescribeAclsRequestData.SCHEMAS;
            case 30:
                return CreateAclsRequestData.SCHEMAS;
            case 31:
                return DeleteAclsRequestData.SCHEMAS;
            case 32:
                return DescribeConfigsRequestData.SCHEMAS;
            case 33:
                return AlterConfigsRequestData.SCHEMAS;
            case 34:
                return AlterReplicaLogDirsRequestData.SCHEMAS;
            case 35:
                return DescribeLogDirsRequestData.SCHEMAS;
            case 36:
                return SaslAuthenticateRequestData.SCHEMAS;
            case 37:
                return CreatePartitionsRequestData.SCHEMAS;
            case 38:
                return CreateDelegationTokenRequestData.SCHEMAS;
            case 39:
                return RenewDelegationTokenRequestData.SCHEMAS;
            case 40:
                return ExpireDelegationTokenRequestData.SCHEMAS;
            case 41:
                return DescribeDelegationTokenRequestData.SCHEMAS;
            case 42:
                return DeleteGroupsRequestData.SCHEMAS;
            case 43:
                return ElectPreferredLeadersRequestData.SCHEMAS;
            default:
                throw new UnsupportedVersionException("Unsupported request API key " + apiKey);
        }
    }
    
    public static Schema[] responseSchemas(short apiKey) {
        switch (apiKey) {
            case 0:
                return ProduceResponseData.SCHEMAS;
            case 1:
                return FetchResponseData.SCHEMAS;
            case 2:
                return ListOffsetResponseData.SCHEMAS;
            case 3:
                return MetadataResponseData.SCHEMAS;
            case 4:
                return LeaderAndIsrResponseData.SCHEMAS;
            case 5:
                return StopReplicaResponseData.SCHEMAS;
            case 6:
                return UpdateMetadataResponseData.SCHEMAS;
            case 7:
                return ControlledShutdownResponseData.SCHEMAS;
            case 8:
                return OffsetCommitResponseData.SCHEMAS;
            case 9:
                return OffsetFetchResponseData.SCHEMAS;
            case 10:
                return FindCoordinatorResponseData.SCHEMAS;
            case 11:
                return JoinGroupResponseData.SCHEMAS;
            case 12:
                return HeartbeatResponseData.SCHEMAS;
            case 13:
                return LeaveGroupResponseData.SCHEMAS;
            case 14:
                return SyncGroupResponseData.SCHEMAS;
            case 15:
                return DescribeGroupsResponseData.SCHEMAS;
            case 16:
                return ListGroupsResponseData.SCHEMAS;
            case 17:
                return SaslHandshakeResponseData.SCHEMAS;
            case 18:
                return ApiVersionsResponseData.SCHEMAS;
            case 19:
                return CreateTopicsResponseData.SCHEMAS;
            case 20:
                return DeleteTopicsResponseData.SCHEMAS;
            case 21:
                return DeleteRecordsResponseData.SCHEMAS;
            case 22:
                return InitProducerIdResponseData.SCHEMAS;
            case 23:
                return OffsetForLeaderEpochResponseData.SCHEMAS;
            case 24:
                return AddPartitionsToTxnResponseData.SCHEMAS;
            case 25:
                return AddOffsetsToTxnResponseData.SCHEMAS;
            case 26:
                return EndTxnResponseData.SCHEMAS;
            case 27:
                return WriteTxnMarkersResponseData.SCHEMAS;
            case 28:
                return TxnOffsetCommitResponseData.SCHEMAS;
            case 29:
                return DescribeAclsResponseData.SCHEMAS;
            case 30:
                return CreateAclsResponseData.SCHEMAS;
            case 31:
                return DeleteAclsResponseData.SCHEMAS;
            case 32:
                return DescribeConfigsResponseData.SCHEMAS;
            case 33:
                return AlterConfigsResponseData.SCHEMAS;
            case 34:
                return AlterReplicaLogDirsResponseData.SCHEMAS;
            case 35:
                return DescribeLogDirsResponseData.SCHEMAS;
            case 36:
                return SaslAuthenticateResponseData.SCHEMAS;
            case 37:
                return CreatePartitionsResponseData.SCHEMAS;
            case 38:
                return CreateDelegationTokenResponseData.SCHEMAS;
            case 39:
                return RenewDelegationTokenResponseData.SCHEMAS;
            case 40:
                return ExpireDelegationTokenResponseData.SCHEMAS;
            case 41:
                return DescribeDelegationTokenResponseData.SCHEMAS;
            case 42:
                return DeleteGroupsResponseData.SCHEMAS;
            case 43:
                return ElectPreferredLeadersResponseData.SCHEMAS;
            default:
                throw new UnsupportedVersionException("Unsupported response API key " + apiKey);
        }
    }
}
