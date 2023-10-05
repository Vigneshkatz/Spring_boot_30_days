package com.katziio.emailverify.repository;

import com.katziio.emailverify.entity.ConfirmationToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ConfirmationTokenRepository extends JpaRepository<ConfirmationToken, String> {

    @Query("SELECT c FROM ConfirmationToken c WHERE c.confirmationToken = :confirmationToken")
    ConfirmationToken findByConfirmationToken(@Param("confirmationToken") String confirmationToken);
}
