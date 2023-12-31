/*
 * Licensed to Elastic Search and Shay Banon under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. Elastic Search licenses this
 * file to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.elasticsearch.client;

import org.elasticsearch.action.ActionFuture;
import org.elasticsearch.action.ActionListener;
import org.elasticsearch.action.admin.cluster.node.info.NodesInfoRequest;
import org.elasticsearch.action.admin.cluster.node.info.NodesInfoResponse;
import org.elasticsearch.action.admin.cluster.ping.broadcast.BroadcastPingRequest;
import org.elasticsearch.action.admin.cluster.ping.broadcast.BroadcastPingResponse;
import org.elasticsearch.action.admin.cluster.ping.replication.ReplicationPingRequest;
import org.elasticsearch.action.admin.cluster.ping.replication.ReplicationPingResponse;
import org.elasticsearch.action.admin.cluster.ping.single.SinglePingRequest;
import org.elasticsearch.action.admin.cluster.ping.single.SinglePingResponse;
import org.elasticsearch.action.admin.cluster.state.ClusterStateRequest;
import org.elasticsearch.action.admin.cluster.state.ClusterStateResponse;

/**
 * Administrative actions/operations against indices.
 *
 * @author kimchy (Shay Banon)
 * @see AdminClient#cluster()
 */
public interface ClusterAdminClient {

    /**
     * The state of the cluster.
     *
     * @param request The cluster state request.
     * @return The result future
     * @see Requests#clusterState()
     */
    ActionFuture<ClusterStateResponse> state(ClusterStateRequest request);

    /**
     * The state of the cluster.
     *
     * @param request  The cluster state request.
     * @param listener A listener to be notified with a result
     * @return The result future
     * @see Requests#clusterState()
     */
    ActionFuture<ClusterStateResponse> state(ClusterStateRequest request, ActionListener<ClusterStateResponse> listener);

    /**
     * The state of the cluster.
     *
     * @param request  The cluster state request.
     * @param listener A listener to be notified with a result
     * @see Requests#clusterState()
     */
    void execState(ClusterStateRequest request, ActionListener<ClusterStateResponse> listener);

    /**
     * Nodes info of the cluster.
     *
     * @param request The nodes info request
     * @return The result future
     * @see org.elasticsearch.client.Requests#nodesInfo(String...)
     */
    ActionFuture<NodesInfoResponse> nodesInfo(NodesInfoRequest request);

    /**
     * Nodes info of the cluster.
     *
     * @param request  The nodes info request
     * @param listener A listener to be notified with a result
     * @return The result future
     * @see org.elasticsearch.client.Requests#nodesInfo(String...)
     */
    ActionFuture<NodesInfoResponse> nodesInfo(NodesInfoRequest request, ActionListener<NodesInfoResponse> listener);

    /**
     * Nodes info of the cluster.
     *
     * @param request  The nodes info request
     * @param listener A listener to be notified with a result
     * @see org.elasticsearch.client.Requests#nodesInfo(String...)
     */
    void execNodesInfo(NodesInfoRequest request, ActionListener<NodesInfoResponse> listener);

    ActionFuture<SinglePingResponse> ping(SinglePingRequest request);

    ActionFuture<SinglePingResponse> ping(SinglePingRequest request, ActionListener<SinglePingResponse> listener);

    void execPing(SinglePingRequest request, ActionListener<SinglePingResponse> listener);

    ActionFuture<BroadcastPingResponse> ping(BroadcastPingRequest request);

    ActionFuture<BroadcastPingResponse> ping(BroadcastPingRequest request, ActionListener<BroadcastPingResponse> listener);

    void execPing(BroadcastPingRequest request, ActionListener<BroadcastPingResponse> listener);

    ActionFuture<ReplicationPingResponse> ping(ReplicationPingRequest request);

    ActionFuture<ReplicationPingResponse> ping(ReplicationPingRequest request, ActionListener<ReplicationPingResponse> listener);

    void execPing(ReplicationPingRequest request, ActionListener<ReplicationPingResponse> listener);
}
