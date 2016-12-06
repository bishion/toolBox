package com.bizi.tools.timer;

import java.util.List;

import com.bizi.tools.exception.BaseAppException;
import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.TriggerBuilder;
import org.quartz.TriggerKey;
import org.quartz.impl.StdSchedulerFactory;

/**
 * @author GuoFB 定时器管理类
 */
public class QuartzManager {
	private static String DEFAULT_JOB_GROUP = "defaultJobGroup";
	private static String DEFAULT_TRIGGER_GROUP = "defaultTriggerGroup";
	private static SchedulerFactory sf = new StdSchedulerFactory();

	/**
	 * 启动指定定时器
	 * 
	 * @throws SchedulerException
	 */
	public static void startQuartz(List<TimerDTO> timerList)
			throws BaseAppException {
		for (TimerDTO timerDTO : timerList) {
			startQuartz(timerDTO);
		}
	}

	/**
	 * 重启指定定时器
	 * 
	 * @throws SchedulerException
	 */
	public static void restartQuartz(TimerDTO timer) throws BaseAppException {
		QuartzManager.removeJob(timer);
		QuartzManager.startQuartz(timer);
	}

	/**
	 * 停止指定定时器
	 * 
	 * @throws SchedulerException
	 * @throws BaseAppException
	 */
	public static void removeJob(TimerDTO timer) throws BaseAppException {
		try {
			Scheduler sched = sf.getScheduler();
			TriggerKey triggerKey = new TriggerKey(timer.getTimerName(),
					DEFAULT_TRIGGER_GROUP);

			JobKey jobKey = new JobKey(timer.getTimerName(), DEFAULT_JOB_GROUP);

			sched.pauseTrigger(triggerKey);

			sched.unscheduleJob(triggerKey);

			sched.deleteJob(jobKey);
		} catch (SchedulerException e) {
			throw new BaseAppException(e);
		}
	}

	/**
	 * 更新指定定时器时间
	 * 
	 * @param timerDTO
	 * @throws SchedulerException
	 */
	public static void modifyJobTime(TimerDTO timerDTO) throws BaseAppException {
		try {
			Scheduler sched = sf.getScheduler();
			CronTrigger trigger = TriggerBuilder
					.newTrigger()
					.withIdentity(timerDTO.getTimerName(),
							DEFAULT_TRIGGER_GROUP)
					.withSchedule(
							CronScheduleBuilder.cronSchedule(timerDTO
									.getExpression())).build();

			sched.rescheduleJob(trigger.getKey(), trigger);
		} catch (SchedulerException e) {
			throw new BaseAppException(e);
		}

	}

	/**
	 * 启动指定定时器
	 * 
	 * @param timer
	 * @throws BaseAppException
	 */
	public static void startQuartz(TimerDTO timer) throws BaseAppException {
		try {

			Scheduler scheduler = sf.getScheduler();

			JobDetail jobDetail = JobBuilder.newJob(timer.getJob().getClass())
					.withIdentity(timer.getTimerName(), DEFAULT_JOB_GROUP)
					.build();

			CronTrigger trigger = TriggerBuilder
					.newTrigger()
					.withIdentity(timer.getTimerName(), DEFAULT_TRIGGER_GROUP)
					.withSchedule(
							CronScheduleBuilder.cronSchedule(timer
									.getExpression())).build();

			scheduler.scheduleJob(jobDetail, trigger);

			if (!scheduler.isShutdown()) {
				scheduler.start();
			}
		} catch (SchedulerException e) {
			throw new BaseAppException(e);
		}
	}

	public static void shutDownALlQuartz() throws BaseAppException {
		try {
			sf.getScheduler().shutdown();
		} catch (SchedulerException e) {
			throw new BaseAppException(e);
		}
	}
}
