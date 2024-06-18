package io.reflectoring.buckpal.adapter.out.persistence;

import java.util.ArrayList;
import java.util.List;

import io.reflectoring.buckpal.application.domain.model.Account;
import io.reflectoring.buckpal.application.domain.model.Account.AccountId;
import io.reflectoring.buckpal.application.domain.model.Activity;
import io.reflectoring.buckpal.application.domain.model.Activity.ActivityId;
import io.reflectoring.buckpal.application.domain.model.ActivityWindow;
import io.reflectoring.buckpal.application.domain.model.Money;
import org.springframework.stereotype.Component;

@Component
class AccountMapper {

	// entity 를 domain 으로 매핑 (AccountJpaEntity -> Account)
	Account mapToDomainEntity(
			AccountJpaEntity account,
			List<ActivityJpaEntity> activities,
			Long withdrawalBalance,
			Long depositBalance) {

		Money baselineBalance = Money.subtract(
				Money.of(depositBalance),
				Money.of(withdrawalBalance));

		return Account.withId(
				new AccountId(account.getId()),
				baselineBalance,
				mapToActivityWindow(activities));

	}

	// entity 를 domain 으로 매핑 (ActivityJpaEntity -> ActivityWindow)
	ActivityWindow mapToActivityWindow(List<ActivityJpaEntity> activities) {
		List<Activity> mappedActivities = new ArrayList<>();

		for (ActivityJpaEntity activity : activities) {
			mappedActivities.add(new Activity(
					new ActivityId(activity.getId()),
					new AccountId(activity.getOwnerAccountId()),
					new AccountId(activity.getSourceAccountId()),
					new AccountId(activity.getTargetAccountId()),
					activity.getTimestamp(),
					Money.of(activity.getAmount())));
		}

		return new ActivityWindow(mappedActivities);
	}

	// domain 을 entity 로 매핑 (Activity -> ActivityJpaEntity)
	ActivityJpaEntity mapToJpaEntity(Activity activity) {
		return new ActivityJpaEntity(
				activity.getId() == null ? null : activity.getId().getValue(),
				activity.getTimestamp(),
				activity.getOwnerAccountId().getValue(),
				activity.getSourceAccountId().getValue(),
				activity.getTargetAccountId().getValue(),
				activity.getMoney().getAmount().longValue());
	}

}
