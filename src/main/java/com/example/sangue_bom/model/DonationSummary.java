package com.example.sangue_bom.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class DonationSummary {
    private String type;
    private Long donationQuantity;
    private String lastDonation;
    private Long nextDonation;

    public DonationSummary(String type, Long donationQuantity, String lastDonation, Long nextDonation) {
        this.type = type;
        this.donationQuantity = donationQuantity;
        this.lastDonation = lastDonation;
        this.nextDonation = nextDonation;
    }
}
