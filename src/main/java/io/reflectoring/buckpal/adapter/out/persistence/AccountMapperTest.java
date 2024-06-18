package io.reflectoring.buckpal.adapter.out.persistence;

import io.reflectoring.buckpal.application.domain.model.Account;
import io.reflectoring.buckpal.application.domain.model.Account.AccountId;
import io.reflectoring.buckpal.application.domain.model.Activity;
import io.reflectoring.buckpal.application.domain.model.Activity.ActivityId;
import io.reflectoring.buckpal.application.domain.model.ActivityWindow;
import io.reflectoring.buckpal.application.domain.model.Money;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingConstants.ComponentModel;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

//@Component
@Mapper(componentModel = ComponentModel.SPRING)
public interface AccountMapperTest {

	AccountMapperTest INSTANCE = Mappers.getMapper(AccountMapperTest.class);

	//Account entityToDomainForAccount(AccountJpaEntity account, List<ActivityJpaEntity> activities, Long withdrawalBalance, Long depositBalance);

	// entity 를 domain 으로 매핑 (AccountJpaEntity -> Account)
	//Account mapToDomainEntity(
	//		AccountJpaEntity account,
	//		List<ActivityJpaEntity> activities,
	//		Long withdrawalBalance,
	//		Long depositBalance) {
	//
	//	Money baselineBalance = Money.subtract(
	//			Money.of(depositBalance),
	//			Money.of(withdrawalBalance));
	//
	//	return Account.withId(
	//			new AccountId(account.getId()),
	//			baselineBalance,
	//			mapToActivityWindow(activities));
	//}

	// entity 를 domain 으로 매핑 (ActivityJpaEntity -> ActivityWindow)
	//ActivityWindow mapToActivityWindow(List<ActivityJpaEntity> activities) {
	//	List<Activity> mappedActivities = new ArrayList<>();
	//
	//	for (ActivityJpaEntity activity : activities) {
	//		mappedActivities.add(new Activity(
	//				new ActivityId(activity.getId()),
	//				new AccountId(activity.getOwnerAccountId()),
	//				new AccountId(activity.getSourceAccountId()),
	//				new AccountId(activity.getTargetAccountId()),
	//				activity.getTimestamp(),
	//				Money.of(activity.getAmount())));
	//	}
	//
	//	return new ActivityWindow(mappedActivities);
	//}

	// domain 을 entity 로 매핑 (Activity -> ActivityJpaEntity)
	//@Mapping(target = "amount", ignore = true)
	//ActivityJpaEntity domainToEntity(Activity activity);

	//ActivityJpaEntity mapToJpaEntity(Activity activity) {
	//	return new ActivityJpaEntity(
	//			activity.getId() == null ? null : activity.getId().getValue(),
	//			activity.getTimestamp(),
	//			activity.getOwnerAccountId().getValue(),
	//			activity.getSourceAccountId().getValue(),
	//			activity.getTargetAccountId().getValue(),
	//			activity.getMoney().getAmount().longValue());
	//}

}
