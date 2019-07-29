#!/bin/bash

generate_key() {
    local FILE=$1
    local TYPE=$2
    local DIR="$(dirname "$FILE")"

    mkdir -p "$DIR"
    ssh-keygen -q -f "${FILE}.tmp" -N '' -t $TYPE

    # Atomically rename file public key
    mv -f "${FILE}.tmp.pub" "${FILE}.pub"

    # This sync does double duty: Ensuring that the data in the temporary
    # private key file is on disk before the rename, and ensuring that the
    # public key rename is completed before the private key rename, since we
    # switch on the existence of the private key to trigger key generation.
    # This does mean it is possible for the public key to exist, but be garbage
    # but this is OK because in that case the private key won't exist and the
    # keys will be regenerated.
    #
    # In the event that sync understands arguments that limit what it tries to
    # fsync(), we provided them. If it does not, it will simply call sync()
    # which is just as well
    sync "${FILE}.pub" "$DIR" "${FILE}.tmp"

    mv "${FILE}.tmp" "$FILE"

    # sync to ensure the atomic rename is committed
    sync "$DIR"
}

cd files

if [ -f "ssh_host_*" ]; then
	rm ssh_host_*
fi

echo "  generating ssh RSA host key..."
generate_key ssh_host_rsa_key rsa
echo "  generating ssh ECDSA host key..."
generate_key ssh_host_ecdsa_key ecdsa
echo "  generating ssh ED25519 host key..."
generate_key ssh_host_ed25519_key ed25519
