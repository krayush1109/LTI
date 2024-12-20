   public void updateBankAccount(BankAccount account) {
        String sql = "UPDATE bank_account SET account_number = ?, account_holder_name = ?, balance = ? WHERE account_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, account.getAccountNumber());
            statement.setString(2, account.getAccountHolderName());
            statement.setDouble(3, account.getBalance());
            statement.setInt(4, account.getAccountId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }