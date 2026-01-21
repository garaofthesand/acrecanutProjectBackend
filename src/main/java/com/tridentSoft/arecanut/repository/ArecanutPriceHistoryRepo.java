package com.tridentSoft.arecanut.repository;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import com.tridentSoft.arecanut.domain.ArecanutPriceHistory;
import com.tridentSoft.arecanut.projectors.PriceTrendProjection;

import org.springframework.data.repository.query.Param;



import java.util.List;

@Repository
public interface ArecanutPriceHistoryRepo
        extends JpaRepository<ArecanutPriceHistory, Long> {

    /* ================= SHORT TERM (WEEKLY) ================= */
    @Query(value = """
        SELECT
            date_trunc('week', price_date)::date AS period,
            ROUND(AVG(price), 2) AS avgPrice
        FROM arecanut_price_history
        WHERE arecanut_type = :type
          AND price_date >= CURRENT_DATE - INTERVAL '12 weeks'
        GROUP BY period
        ORDER BY period
        """, nativeQuery = true)
    List<PriceTrendProjection> fetchWeeklyTrend(@Param("type") String type);


    /* ================= MID TERM (MONTHLY) ================= */
    @Query(value = """
        SELECT
            date_trunc('month', price_date)::date AS period,
            ROUND(AVG(price), 2) AS avgPrice
        FROM arecanut_price_history
        WHERE arecanut_type = :type
          AND price_date >= CURRENT_DATE - INTERVAL '12 months'
        GROUP BY period
        ORDER BY period
        """, nativeQuery = true)
    List<PriceTrendProjection> fetchMonthlyTrend(@Param("type") String type);


    /* ================= LONG TERM (YEARLY) ================= */
    @Query(value = """
        SELECT
            date_trunc('year', price_date)::date AS period,
            ROUND(AVG(price), 2) AS avgPrice
        FROM arecanut_price_history
        WHERE arecanut_type = :type
          AND price_date >= CURRENT_DATE - INTERVAL '10 years'
        GROUP BY period
        ORDER BY period
        """, nativeQuery = true)
    List<PriceTrendProjection> fetchYearlyTrend(@Param("type") String type);
}
