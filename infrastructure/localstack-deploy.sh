#!/bin/bash
set -e # Stops the script if any command fails

#aws --endpoint-url=http://localhost:4566 cloudformation deploy \
#    --stack-name patient-management

#aws logs delete-log-group \
#  --log-group-name "/aws/api-gateway/patient-management" \
#  --endpoint-url=http://localhost:4566 \
#  --region us-east-1

aws --endpoint-url=http://localhost:4566 cloudformation deploy \
    --stack-name patient-management \
    --template-file "/Users/harikrishnareddy/Desktop/patient-mangement/infrastructure/cdk.out/localstack.template.json"

aws --endpoint-url=http://localhost:4566 elbv2 describe-load-balancers \
    --query "LoadBalancers[0].DNSName" --output text

aws --endpoint-url=http://localhost:4566 cloudformation list-stacks