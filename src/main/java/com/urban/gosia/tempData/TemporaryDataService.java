package com.urban.gosia.tempData;

import com.urban.gosia.bankAccount.BankAccount;
import com.urban.gosia.bankAccount.BankAccountNotFoundException;
import com.urban.gosia.bankAccount.BankAccountService;
import com.urban.gosia.exceptions.CyclicPeriodNotFoundException;
import com.urban.gosia.transaction.models.CyclicTransactionPeriod;
import com.urban.gosia.transaction.models.Transaction;
import com.urban.gosia.transaction.models.dto.CreateCyclicTransactionDto;
import com.urban.gosia.transaction.services.CyclicTransactionPeriodService;
import com.urban.gosia.transaction.services.CyclicTransactionService;
import lombok.Data;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Data
@Service
public class TemporaryDataService {
    private final CyclicTransactionService cyclicTransactionService;
    private final BankAccountService bankAccountService;

    private final CyclicTransactionPeriodService transactionPeriodService;

    @PostConstruct
    public void createBankAccounts(){
        BankAccount eurobank = BankAccount.builder()
                .bankName("Eurobank")
                .accountNumber("1111 2222 3333 4444 5555")
                .accountType(BankAccount.BankAccountTypes.EXPENSES)
                .balanceUpdate(new Date())
                .currentBalance(new BigDecimal(2000))
                .build();
        bankAccountService.save(eurobank);

        BankAccount mBank = BankAccount.builder()
                .bankName("mBank")
                .accountNumber("6666 7777 8888 99999 0001")
                .accountType(BankAccount.BankAccountTypes.SAVINGS)
                .balanceUpdate(new Date())
                .currentBalance(new BigDecimal(28000))
                .build();
        bankAccountService.save(mBank);
    }

    @PostConstruct
    public void createCyclicCostPeriodDictionary(){
        transactionPeriodService.save(CyclicTransactionPeriod.builder().name("Co tydzień").build());
        transactionPeriodService.save(CyclicTransactionPeriod.builder().name("Co miesiąc").build());
        transactionPeriodService.save(CyclicTransactionPeriod.builder().name("Co dwa miesiące").build());
        transactionPeriodService.save(CyclicTransactionPeriod.builder().name("Co trzy miesiące").build());
        transactionPeriodService.save(CyclicTransactionPeriod.builder().name("Co pół roku").build());
        transactionPeriodService.save(CyclicTransactionPeriod.builder().name("Co rok").build());
    }

    @PostConstruct
    public void createCyclicTransactions() throws BankAccountNotFoundException, ParseException, CyclicPeriodNotFoundException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        CreateCyclicTransactionDto netflix = CreateCyclicTransactionDto.builder()
                .name("Netflix")
                .value(new BigDecimal(43))
                .firstPayDate(dateFormat.parse("2019-01-26"))
                .lastPayDate(null)
                .trancastionPeriodId(2)
                .costDirection(Transaction.CostDirection.OUTGOING)
                .build();
        cyclicTransactionService.save(netflix);

        CreateCyclicTransactionDto smieci = CreateCyclicTransactionDto.builder()
                .name("Wywóz śmieci")
                .value(new BigDecimal(36))
                .firstPayDate(dateFormat.parse("2019-01-10"))
                .lastPayDate(null)
                .trancastionPeriodId(4)
                .costDirection(Transaction.CostDirection.OUTGOING)
                .build();
        cyclicTransactionService.save(smieci);

        CreateCyclicTransactionDto woda = CreateCyclicTransactionDto.builder()
                .name("Woda")
                .value(new BigDecimal(230))
                .firstPayDate(dateFormat.parse("2019-01-27"))
                .lastPayDate(null)
                .trancastionPeriodId(3)
                .costDirection(Transaction.CostDirection.OUTGOING)
                .build();
        cyclicTransactionService.save(woda);

        CreateCyclicTransactionDto njuGosia = CreateCyclicTransactionDto.builder()
                .name("NjuMobile Gosia")
                .value(new BigDecimal(30))
                .firstPayDate(dateFormat.parse("2019-01-21"))
                .lastPayDate(null)
                .trancastionPeriodId(2)
                .costDirection(Transaction.CostDirection.OUTGOING)
                .build();
        cyclicTransactionService.save(njuGosia);

        CreateCyclicTransactionDto kredytowka = CreateCyclicTransactionDto.builder()
                .name("Spłata kredytówki")
                .value(new BigDecimal(351.13))
                .firstPayDate(dateFormat.parse("2019-01-16"))
                .lastPayDate(null)
                .trancastionPeriodId(2)
                .costDirection(Transaction.CostDirection.OUTGOING)
                .build();
        cyclicTransactionService.save(kredytowka);

        CreateCyclicTransactionDto rataKredyt = CreateCyclicTransactionDto.builder()
                .name("Rata kredytu")
                .value(new BigDecimal(1463.57))
                .firstPayDate(dateFormat.parse("2019-01-15"))
                .lastPayDate(null)
                .trancastionPeriodId(2)
                .costDirection(Transaction.CostDirection.OUTGOING)
                .build();
        cyclicTransactionService.save(rataKredyt);

        CreateCyclicTransactionDto gaz = CreateCyclicTransactionDto.builder()
                .name("Gaz PGNiG")
                .value(new BigDecimal(175))
                .firstPayDate(dateFormat.parse("2019-01-13"))
                .lastPayDate(null)
                .trancastionPeriodId(2)
                .costDirection(Transaction.CostDirection.OUTGOING)
                .build();
        cyclicTransactionService.save(gaz);

        CreateCyclicTransactionDto nc = CreateCyclicTransactionDto.builder()
                .name("NC+")
                .value(new BigDecimal(94.99))
                .firstPayDate(dateFormat.parse("2019-01-11"))
                .lastPayDate(null)
                .trancastionPeriodId(2)
                .costDirection(Transaction.CostDirection.OUTGOING)
                .build();
        cyclicTransactionService.save(nc);

        CreateCyclicTransactionDto njuPawel = CreateCyclicTransactionDto.builder()
                .name("NjuMobile Paweł")
                .value(new BigDecimal(40.00))
                .firstPayDate(dateFormat.parse("2019-01-10"))
                .lastPayDate(null)
                .trancastionPeriodId(2)
                .costDirection(Transaction.CostDirection.OUTGOING)
                .build();
        cyclicTransactionService.save(njuPawel);

        CreateCyclicTransactionDto emu = CreateCyclicTransactionDto.builder()
                .name("Internet EMU")
                .value(new BigDecimal(89))
                .firstPayDate(dateFormat.parse("2019-01-10"))
                .lastPayDate(null)
                .trancastionPeriodId(2)
                .costDirection(Transaction.CostDirection.OUTGOING)
                .build();
        cyclicTransactionService.save(emu);

        CreateCyclicTransactionDto prad = CreateCyclicTransactionDto.builder()
                .name("Prąd Tauron")
                .value(new BigDecimal(103.57))
                .firstPayDate(dateFormat.parse("2019-01-10"))
                .lastPayDate(null)
                .trancastionPeriodId(2)
                .costDirection(Transaction.CostDirection.OUTGOING)
                .build();
        cyclicTransactionService.save(prad);
    }
}
