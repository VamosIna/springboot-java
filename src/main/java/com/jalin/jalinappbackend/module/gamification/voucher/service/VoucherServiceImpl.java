package com.jalin.jalinappbackend.module.gamification.voucher.service;

import com.jalin.jalinappbackend.exception.ResourceNotFoundException;
import com.jalin.jalinappbackend.module.gamification.voucher.entity.Voucher;
import com.jalin.jalinappbackend.module.gamification.voucher.repository.VoucherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class VoucherServiceImpl implements VoucherService {

    @Autowired
    private VoucherRepository voucherRepository;

    @Override
    public List<Voucher> getAllVouchers() {
        return voucherRepository.findAll();
    }

    @Override
    public Voucher getVoucher(UUID voucherId) {
        return voucherRepository.findById(voucherId)
                .orElseThrow(() -> new ResourceNotFoundException("Voucher not found"));
    }

    @Override
    public void addVoucher(Voucher voucher) {
        voucherRepository.save(voucher);
    }

    @Override
    public void updateVoucher(UUID voucherId, Voucher voucher) {
        Voucher findVoucher = voucherRepository.findById(voucherId)
                .orElseThrow(() -> new ResourceNotFoundException("Voucher not found"));

        findVoucher.setCategory(voucher.getCategory());
        findVoucher.setTncDescription(voucher.getTncDescription());
        findVoucher.setPoints(voucher.getPoints());
        findVoucher.setQuota(voucher.getQuota());
        findVoucher.setUsage(voucher.getUsage());
        findVoucher.setValidity(voucher.getValidity());

        voucherRepository.save(findVoucher);
    }

    @Override
    public void deleteVoucher(UUID voucherId) {
        Voucher voucher = voucherRepository.findById(voucherId)
                .orElseThrow(() -> new ResourceNotFoundException("Voucher not found"));

        voucherRepository.delete(voucher);
    }
}
