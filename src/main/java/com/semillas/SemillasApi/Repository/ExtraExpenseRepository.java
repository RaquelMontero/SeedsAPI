package com.semillas.SemillasApi.Repository;

import com.semillas.SemillasApi.Entities.Seeds.ConstantContribution;
import com.semillas.SemillasApi.Entities.SeedsTracking.ExtraExpense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExtraExpenseRepository extends JpaRepository<ExtraExpense,Long> {
}
