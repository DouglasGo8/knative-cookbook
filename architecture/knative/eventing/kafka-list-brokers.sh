#!/bin/bash
set -e

trap '{ echo "" ; exit 1; }' INT

KAFKA_CLUSTER_NS=${1:-'myproject'}
KAFKA_CLUSTER_NAME=${2:-'my-cluster'}

#pod_number=$(shuf -i 0-1 -n 1)
kubectl exec -it "$KAFKA_CLUSTER_NAME-kafka-0" \
 -n $KAFKA_CLUSTER_NS \
 -- ./bin/zookeeper-shell.sh localhost:2181