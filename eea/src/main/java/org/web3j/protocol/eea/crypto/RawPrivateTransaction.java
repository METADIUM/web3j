/*
 * Copyright 2019 Web3 Labs Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */
package org.web3j.protocol.eea.crypto;

import java.math.BigInteger;
import java.util.List;
import java8.util.Optional;

import org.web3j.crypto.RawTransaction;
import org.web3j.crypto.transaction.type.ITransaction;
import org.web3j.crypto.transaction.type.LegacyTransaction;
import org.web3j.crypto.transaction.type.Transaction1559;
import org.web3j.utils.Base64String;
import org.web3j.utils.Restriction;

/**
 * Transaction class used for signing transactions locally.<br>
 * For the specification, refer to p4 of the <a href="http://gavwood.com/paper.pdf">yellow
 * paper</a>.
 */
public class RawPrivateTransaction extends RawTransaction {

    protected RawPrivateTransaction(
            final BigInteger nonce,
            final BigInteger gasPrice,
            final BigInteger gasLimit,
            final String to,
            final String data,
            final Base64String privateFrom,
            final List<Base64String> privateFor,
            final Base64String privacyGroupId,
            final Restriction restriction) {
        super(new LegacyTransaction(nonce, gasPrice, gasLimit, to, BigInteger.ZERO, data));
        this.privateFrom = privateFrom;
        this.privateFor = privateFor;
        this.privacyGroupId = privacyGroupId;
        this.restriction = restriction;
    }

    protected RawPrivateTransaction(
            final ITransaction transaction,
            final Base64String privateFrom,
            final List<Base64String> privateFor,
            final Base64String privacyGroupId,
            final Restriction restriction) {
        super(transaction);
        this.privateFrom = privateFrom;
        this.privateFor = privateFor;
        this.privacyGroupId = privacyGroupId;
        this.restriction = restriction;
    }

    private final Base64String privateFrom;
    private final List<Base64String> privateFor;
    private final Base64String privacyGroupId;
    private final Restriction restriction;

    protected RawPrivateTransaction(
            final RawTransaction rawTransaction,
            final Base64String privateFrom,
            final Base64String privacyGroupId,
            final Restriction restriction) {
        this(rawTransaction, privateFrom, null, privacyGroupId, restriction);
    }

    protected RawPrivateTransaction(
            final RawTransaction rawTransaction,
            final Base64String privateFrom,
            final List<Base64String> privateFor,
            final Restriction restriction) {
        this(rawTransaction, privateFrom, privateFor, null, restriction);
    }

    private RawPrivateTransaction(
            final RawTransaction rawTransaction,
            final Base64String privateFrom,
            final List<Base64String> privateFor,
            final Base64String privacyGroupId,
            final Restriction restriction) {
        this(rawTransaction.getTransaction(), privateFrom, privateFor, privacyGroupId, restriction);
    }

    public static RawPrivateTransaction createContractTransaction(
            final BigInteger nonce,
            final BigInteger gasPrice,
            final BigInteger gasLimit,
            final String init,
            final Base64String privateFrom,
            final List<Base64String> privateFor,
            final Restriction restriction) {

        return new RawPrivateTransaction(
                LegacyTransaction.createContractTransaction(
                        nonce, gasPrice, gasLimit, BigInteger.ZERO, init),
                privateFrom,
                privateFor,
                null,
                restriction);
    }

    public static RawPrivateTransaction createContractTransaction(
            final BigInteger nonce,
            final BigInteger gasPrice,
            final BigInteger gasLimit,
            final String init,
            final Base64String privateFrom,
            final Base64String privacyGroupId,
            final Restriction restriction) {

        return new RawPrivateTransaction(
                LegacyTransaction.createContractTransaction(
                        nonce, gasPrice, gasLimit, BigInteger.ZERO, init),
                privateFrom,
                null,
                privacyGroupId,
                restriction);
    }

    public static RawPrivateTransaction createTransaction(
            final BigInteger nonce,
            final BigInteger gasPrice,
            final BigInteger gasLimit,
            final String to,
            final String data,
            final Base64String privateFrom,
            final List<Base64String> privateFor,
            final Restriction restriction) {

        return new RawPrivateTransaction(
                LegacyTransaction.createTransaction(nonce, gasPrice, gasLimit, to, data),
                privateFrom,
                privateFor,
                null,
                restriction);
    }

    public static RawPrivateTransaction createTransaction(
            final BigInteger nonce,
            final BigInteger gasPrice,
            final BigInteger gasLimit,
            final String to,
            final String data,
            final Base64String privateFrom,
            final Base64String privacyGroupId,
            final Restriction restriction) {

        return new RawPrivateTransaction(
                LegacyTransaction.createTransaction(nonce, gasPrice, gasLimit, to, data),
                privateFrom,
                null,
                privacyGroupId,
                restriction);
    }

    public static RawPrivateTransaction createTransaction(
            final long chainId,
            final BigInteger nonce,
            final BigInteger maxPriorityFeePerGas,
            final BigInteger maxFeePerGas,
            final BigInteger gasLimit,
            final String to,
            final String data,
            final Base64String privateFrom,
            final List<Base64String> privateFor,
            final Restriction restriction) {
        return new RawPrivateTransaction(
                Transaction1559.createTransaction(
                        chainId,
                        nonce,
                        gasLimit,
                        to,
                        BigInteger.ZERO,
                        data,
                        maxPriorityFeePerGas,
                        maxFeePerGas),
                privateFrom,
                privateFor,
                null,
                restriction);
    }

    public static RawPrivateTransaction createTransaction(
            final long chainId,
            final BigInteger nonce,
            final BigInteger maxPriorityFeePerGas,
            final BigInteger maxFeePerGas,
            final BigInteger gasLimit,
            final String to,
            final String data,
            final Base64String privateFrom,
            final Base64String privacyGroupId,
            final Restriction restriction) {

        return new RawPrivateTransaction(
                Transaction1559.createTransaction(
                        chainId,
                        nonce,
                        gasLimit,
                        to,
                        BigInteger.ZERO,
                        data,
                        maxPriorityFeePerGas,
                        maxFeePerGas),
                privateFrom,
                null,
                privacyGroupId,
                restriction);
    }

    public Base64String getPrivateFrom() {
        return privateFrom;
    }

    public Optional<List<Base64String>> getPrivateFor() {
        return Optional.ofNullable(privateFor);
    }

    public Optional<Base64String> getPrivacyGroupId() {
        return Optional.ofNullable(privacyGroupId);
    }

    public Restriction getRestriction() {
        return restriction;
    }
}
