package com.lpj.wxgzhh.repository;

import com.lpj.wxgzhh.domain.StoreDialogue;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.ArrayList;

@Repository
public interface DialogueRepository extends JpaRepository<StoreDialogue, String> {

    // 根据发送者和接收者查询未收消息数量
    @Query(value = "select count(*) from store_dialogue where reception_id=:receptionId and send_id=:sendId" +
            " and dialogue_state='IS_UNREAD'", nativeQuery=true)
    int findUnreadNumById(@Param("sendId")String sendId ,@Param("receptionId")String receptionId);

    // 根据接收者id查询发送者
    @Query(value = "select send_id from store_dialogue where reception_id=:receptionId", nativeQuery=true)
    ArrayList<String> findUserIdByReceptionId(@Param("receptionId")String receptionId);

    // 根据发送者查询接收者
    @Query(value = "select reception_id from store_dialogue where send_id=:sendId", nativeQuery=true)
    ArrayList<String> findUserIdBySendId(@Param("sendId")String sendId);

    // 根据发送者和接收者查看最后一条消息
    @Query(value = "select dialogue_text,dialogue_time from (select  * from store_dialogue where (reception_id=:receptionId and send_id=" +
            ":sendId) or (reception_id=:sendId and send_id=:receptionId) Order By dialogue_time Desc ) as t limit 1", nativeQuery=true)
    String findLastMessage (@Param("receptionId")String receptionId,@Param("sendId")String sendId);

    // 根据发送者id和接收者id查询所有消息
    @Query(value = "select  * from store_dialogue where (reception_id=:receptionId and send_id=:sendId) " +
            "or (reception_id=:sendId and send_id=:receptionId) Order By dialogue_time ASC", nativeQuery=true)
    ArrayList<StoreDialogue> findDialogueByReceptionIdAndSendId(@Param("receptionId")String receptionId, @Param("sendId")String sendId);

    // 根据发送者id和接收者id将未读状态更新
    @Transactional
    @Modifying
    @Query(value = "update store_dialogue set dialogue_state='IS_READ' where reception_id=:receptionId and send_id=:sendId",
            nativeQuery=true)
    int saveState(@Param("receptionId")String receptionId,@Param("sendId")String sendId);

    // 增加消息
    <S extends StoreDialogue> S save(S entity);
}
