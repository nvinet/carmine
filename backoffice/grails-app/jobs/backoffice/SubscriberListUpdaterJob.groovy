package backoffice


class SubscriberListUpdaterJob {

    def subscribersBatchService

    def triggers = {
        cron name: 'everyDayAtMidnight', cronExpression: "0 0 0 * * ?"
    }

    def execute() {
        ['GB','FR'].each {
            subscribersBatchService.generateList(it)
        }
    }
}
