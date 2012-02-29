databaseChangeLog = {

    changeSet(author: "Nico (generated)", id: "1308492693760-18") {
        dropColumn(columnName: "email", tableName: "customer")
    }
}
