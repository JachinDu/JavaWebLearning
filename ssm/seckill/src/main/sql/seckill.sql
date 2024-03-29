--秒杀执行 存储过程
--将分行符号由；变为$$
DELIMITER $$

--定义存储过程
--参数：in:输入参数  out:输出参数
--row_count():返回上一条修改类型sql的影响行数
--row_count()结果：0：未修改数据；>0：表示修改的行数；<0表示sql错误/未执行修改sql
create
    definer = root@localhost procedure execute_seckill(IN v_seckill_id bigint, IN v_phone bigint,
                                                       IN v_kill_time timestamp, OUT r_result int)
BEGIN
    DECLARE insert_count int DEFAULT 0;
    START TRANSACTION;
    insert ignore into success_killed
    (seckill_id,user_phone,create_time)
    values (v_seckill_id,v_phone,v_kill_time);
    select row_count() into insert_count;
    if (insert_count = 0) then
        rollback ;
        set r_result = -1;
    elseif(insert_count < 0) then
        rollback ;
        set r_result = -2;
    else
        update seckill
        set number  = number -1
        where seckill_id = v_seckill_id
          and end_time > v_kill_time
          and start_time < v_kill_time
          and number > 0;

        select row_count() into insert_count;
        if (insert_count = 0) then
            rollback ;
            set r_result = 0;
        elseif(insert_count < 0) then
            rollback ;
            set r_result = -2;
        else
            commit;
            set r_result = 1;
        end if;
    end if;
end;
$$
--存储过程定义结束


DELIMITER ;

--console定义变量用@,存储过程用declare
set @r_result = -3;
--执行存储过程
call execute_seckill(1000,12398456758,now(),@r_result);

--获取结果
select @r_result;

