package com.pyy.qa.com.pyy.qa.dao;

import com.pyy.qa.com.pyy.qa.pojo.Problem;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

/**
 * 数据访问接口
 * @author Administrator
 *
 */
public interface ProblemDao extends JpaRepository<Problem,String>,JpaSpecificationExecutor<Problem>{

    @Query(value = "select * from tb_problem tp, tb_pl tpl  where tp.id = tpl.problemid and tpl.labelid = ? order by tp.replytime desc ", nativeQuery = true)
    Page<Problem> newList(String labelid, Pageable pageable);

    @Query(value = "select * from tb_problem tp, tb_pl tpl  where tp.id = tpl.problemid and tpl.labelid = ? order by tp.reply desc ", nativeQuery = true)
    Page<Problem> hotlist(String labelid, Pageable pageable);

    @Query(value = "select * from tb_problem tp, tb_pl tpl  where tp.id = tpl.problemid and tpl.labelid = ? and tp.reply = 0 order by tp.createtime desc ", nativeQuery = true)
    Page<Problem> waitlist(String labelid, Pageable pageable);
}
