#!/bin/bash

nohup java -cp .:lib/* org.apache.zookeeper.inspector.ZooInspector > ZooInspector.log &