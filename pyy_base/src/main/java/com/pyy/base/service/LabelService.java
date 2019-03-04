package com.pyy.base.service;


import com.pyy.base.dao.LabelDao;
import com.pyy.base.entity.PageResult;
import com.pyy.base.model.Label;
import com.pyy.base.utils.IdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * 标签业务逻辑接类
 */
@Service
@Transactional
public class LabelService {
    @Autowired
    private LabelDao labelDao;
    @Autowired
    private IdWorker idWorker;

    /**
     * 查询全部标签
     * @return
     */
    public List<Label> findAll(){
        return labelDao.findAll();
    }

    /**
     * 根据ID查询标签
     * @return
     */
    public Label findById(String id){
        return labelDao.findById(id).get();
    }

    /**
     * 增加标签
     * @param label
     */
    public void add(Label label){
        label.setId(idWorker.nextId() + "");
        labelDao.save(label);
    }

    /**
     * 修改标签
     * @param label
     */
    public void update(Label label){
        labelDao.save(label);
    }

    /**
     * 删除标签
     * @param id
     */
    public void deleteById(String id){
        labelDao.deleteById(id);
    }

    /**
     * 标签条件查询
     * @param label
     * @return
     */
    public List<Label> search(Label label) {
        return labelDao.findAll(getSpecification(label));
    }



    /**
     * 分页查询
     * @param label
     * @param page
     * @param size
     * @return
     */
    public PageResult<Label> pageQuery(Label label, int page, int size) {
        Pageable pageAble = PageRequest.of(page - 1, size);
        Page<Label> p = labelDao.findAll(getSpecification(label), pageAble);

        return new PageResult<Label>(p.getTotalElements(), p.getContent());
    }

    /**
     * 封装查询条件
     * @param label
     * @return
     */
    private Specification<Label> getSpecification(Label label) {
        return new Specification<Label>() {
            /**
             * 查询条件
             * @param root 根对象，封装查询条件 where 字段名 对应 label.getXXX（）
             * @param criteriaQuery 封装查询关键字 比如：group by order by
             * @param criteriaBuilder 封装条件对象，如果直接返回null，表示不需要任何条件
             * @return
             */
            @Override
            public Predicate toPredicate(Root<Label> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> list = new ArrayList<>();
                if (!StringUtils.isEmpty(label.getLabelName())) {
                    // label_name like  '%小明%'
                    Predicate predicate = criteriaBuilder.like(root.get("labelName").as(String.class), "%" + label.getLabelName() + "%");
                    list.add(predicate);
                }

                if (!StringUtils.isEmpty(label.getState())) {
                    // state = '1'
                    Predicate predicate = criteriaBuilder.equal(root.get("state").as(String.class), label.getState());
                    list.add(predicate);
                }

                Predicate[] predicates = new Predicate[list.size()];
                list.toArray(predicates);
                return criteriaBuilder.and(predicates);
            }
        };
    }
}