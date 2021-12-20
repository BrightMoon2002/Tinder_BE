package com.codegym.repository.message;

import com.codegym.model.account.Account;
import com.codegym.model.message.Message;
import org.springframework.boot.actuate.autoconfigure.metrics.export.wavefront.WavefrontProperties;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IMessageRepository extends JpaRepository<Message, Long> {
    Iterable<Message> findAllBySender(Account sender);

    Iterable<Message> findAllByReceiver(Account receiver);

    Iterable<Message> findAllBySenderAndReceiver(Account sender, Account receiver);

    Iterable<Message> findAllBySenderOrReceiver(Account sender, Account receiver);

    Iterable<Message> findAllBySenderOrReceiverOrderByReceiver(Account sender, Account receiver);
    Iterable<Message> findAllByReceiverOrSenderOrderByReceiver(Account sender, Account receiver);
    @Query(value = "SELECT m from Message m having m.receiver = ?1 or m.sender = ?2 order by m.receiver = ?3", nativeQuery = true)
    Iterable<Message> customFindAllBySenderOrReceiverOrderByReceiver(Account receiver, Account sender, Account receiver2);
}
