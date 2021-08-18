package com.nordbank.dockerspringboot;

import org.springframework.boot.context.event.ApplicationContextInitializedEvent;
import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.boot.context.event.ApplicationFailedEvent;
import org.springframework.boot.context.event.ApplicationPreparedEvent;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.boot.context.event.SpringApplicationEvent;
import org.springframework.context.ApplicationListener;

public class SpringBuiltInEventsListener implements ApplicationListener<SpringApplicationEvent>{

	// 1. An ApplicationStartingEvent is sent at the start of a run but before any processing, except for the registration of listeners and initializers.
	// 2. An ApplicationEnvironmentPreparedEvent is sent when the Environment to be used in the context is known but before the context is created.
	// 3. An ApplicationContextInitializedEvent is sent when the ApplicationContext is prepared and ApplicationContextInitializers have been called but before any bean definitions are loaded.
	// 4. An ApplicationPreparedEvent is sent just before the refresh is started but after bean definitions have been loaded.
	// 5. An ApplicationStartedEvent is sent after the context has been refreshed but before any application and command-line runners have been called.
	// 6. An ApplicationReadyEvent is sent after any application and command-line runners have been called. It indicates that the application is ready to service requests.
	// 7. An ApplicationFailedEvent is sent if there is an exception on startup.

  @Override
  public void onApplicationEvent(SpringApplicationEvent event) {
    
    // System.out.println(event.toString());

    // 1. ApplicationContextInitializedEvent
    if (event instanceof ApplicationContextInitializedEvent) {
      System.out.println("### 1. ApplicationContextInitializedEvent");
    } 
    // 2. ApplicationEnvironmentPreparedEvent
    else if (event instanceof ApplicationEnvironmentPreparedEvent) {
      System.out.println("### 2. ApplicationEnvironmentPreparedEvent");
    } 
    // 3. ApplicationContextInitializedEvent
    else if (event instanceof ApplicationContextInitializedEvent) {
      System.out.println("### 3. ApplicationContextInitializedEvent");
    } 
    // 4. ApplicationPreparedEvent
    else if (event instanceof ApplicationPreparedEvent) {
      System.out.println("### 4. ApplicationPreparedEvent");
    } 
    // 5. ApplicationStartedEvent
    else if (event instanceof ApplicationStartedEvent) {
      System.out.println("### 5. ApplicationStartedEvent");
    } 
    // 6. ApplicationReadyEvent
    else if (event instanceof ApplicationReadyEvent) {
      System.out.println("### 6. ApplicationReadyEvent");
    } 
    // 7. ApplicationFailedEvent
    else if (event instanceof ApplicationFailedEvent) {
      System.out.println("### 7. ApplicationFailedEvent");
    }
  }
}