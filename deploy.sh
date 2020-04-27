#! /bin/bash

echo '{"status": { "name": "value"}}' | jq --raw-output .status.name
