INSERT INTO `bank_account`(`id`, `account_number`, `account_type`, `bank_name`, `current_balance`) VALUES (1, '1111 2222 33333 4444', 'EXPENSES', 'Eurobank', 0);
INSERT INTO `bank_account`(`id`, `account_number`, `account_type`, `bank_name`, `current_balance`) VALUES (2, '5555 6666 7777 8888', 'SAVINGS', 'mBank', 2500.55);

INSERT INTO `account_balance` (`id`, `update_date`, `value`, `bank_account_id`) VALUES (RANDOM_UUID(), NOW(), 25000.77, 1);
INSERT INTO `account_balance` (`id`, `update_date`, `value`, `bank_account_id`) VALUES (RANDOM_UUID(), NOW(), 6522.77, 2);
INSERT INTO `account_balance` (`id`, `update_date`, `value`, `bank_account_id`) VALUES (RANDOM_UUID(), NOW(), 8755.77, 1);
INSERT INTO `account_balance` (`id`, `update_date`, `value`, `bank_account_id`) VALUES (RANDOM_UUID(), NOW(), 1111.77, 2);

INSERT INTO `costs` (`id`, `name`, `value`, `is_cyclic`, `cost_direction`, `pay_date`, `bank_account_id`, `is_active`) VALUES (RANDOM_UUID(), 'Prąd', 110.25, true, 'OUTGOING', NOW(), 1, true );
INSERT INTO `costs` (`id`, `name`, `value`, `is_cyclic`, `cost_direction`, `pay_date`, `bank_account_id`, `is_active`) VALUES (RANDOM_UUID(), 'Gaz', 256.25, true, 'OUTGOING', NOW(), 1, true );
INSERT INTO `costs` (`id`, `name`, `value`, `is_cyclic`, `cost_direction`, `pay_date`, `bank_account_id`, `is_active`) VALUES (RANDOM_UUID(), 'Woda', 450.89, true, 'OUTGOING', NOW(), 1, true );
INSERT INTO `costs` (`id`, `name`, `value`, `is_cyclic`, `cost_direction`, `pay_date`, `bank_account_id`, `is_active`) VALUES (RANDOM_UUID(), 'Taras', 5000, false, 'OUTGOING', NOW(), 2, true );
INSERT INTO `costs` (`id`, `name`, `value`, `is_cyclic`, `cost_direction`, `pay_date`, `bank_account_id`, `is_active`) VALUES (RANDOM_UUID(), 'Markiza', 7500, false, 'OUTGOING', NOW(), 2, true );
INSERT INTO `costs` (`id`, `name`, `value`, `is_cyclic`, `cost_direction`, `pay_date`, `bank_account_id`, `is_active`) VALUES (RANDOM_UUID(), 'Szkolenia', 8000, false, 'INCOMING', NOW(), 2, true );
INSERT INTO `costs` (`id`, `name`, `value`, `is_cyclic`, `cost_direction`, `pay_date`, `bank_account_id`, `is_active`) VALUES (RANDOM_UUID(), 'Bonus', 2500, false, 'INCOMING', NOW(), 2, true );