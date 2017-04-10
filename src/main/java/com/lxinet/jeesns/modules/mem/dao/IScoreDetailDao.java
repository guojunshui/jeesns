package com.lxinet.jeesns.modules.mem.dao;

import com.lxinet.jeesns.core.dao.IBaseDao;
import com.lxinet.jeesns.core.entity.Page;
import com.lxinet.jeesns.modules.mem.entity.MemberFans;
import com.lxinet.jeesns.modules.mem.entity.ScoreDetail;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * Created by zchuanzhao on 2017/2/16.
 */
public interface IScoreDetailDao extends IBaseDao<ScoreDetail> {

    List<ScoreDetail> listByPage(@Param("page") Page page, @Param("memberId") Integer memberId);

    /**
     * 是否能奖励，如果返回记录为0，表示可以奖励
     * @param memberId
     * @param scoreRuleId
     * @param type
     * @return
     */
    List<ScoreDetail> canBonus(@Param("memberId") Integer memberId, @Param("scoreRuleId") Integer scoreRuleId, @Param("type") String type);

    /**
     * 根据会员、获取奖励的外键、奖励规则ID获取奖励激励，不包括foreign_id=0
     * @param memberId
     * @param scoreRuleId
     * @param foreignId
     * @return
     */
    ScoreDetail findByForeignAndRule(@Param("memberId") Integer memberId, @Param("scoreRuleId") Integer scoreRuleId, @Param("foreignId") Integer foreignId);
}