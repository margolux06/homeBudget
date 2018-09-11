INSERT INTO `bank_account`(`id`, `account_number`, `account_type`, `bank_name`, `current_balance`) VALUES (1, '1111 2222 33333 4444', 'EXPENSES', 'Eurobank', 0);
INSERT INTO `bank_account`(`id`, `account_number`, `account_type`, `bank_name`, `current_balance`) VALUES (2, '5555 6666 7777 8888', 'SAVINGS', 'mBank', 2500.55);

INSERT INTO `account_balance` (`id`, `update_date`, `value`, `bank_account_id`) VALUES (RANDOM_UUID(), NOW(), 25000.77, 1);
INSERT INTO `account_balance` (`id`, `update_date`, `value`, `bank_account_id`) VALUES (RANDOM_UUID(), NOW(), 6522.77, 2);
INSERT INTO `account_balance` (`id`, `update_date`, `value`, `bank_account_id`) VALUES (RANDOM_UUID(), NOW(), 8755.77, 1);
INSERT INTO `account_balance` (`id`, `update_date`, `value`, `bank_account_id`) VALUES (RANDOM_UUID(), NOW(), 1111.77, 2);