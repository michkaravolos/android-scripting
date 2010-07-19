/*
 * Copyright (C) 2009 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package com.googlecode.android_scripting;

import android.app.Application;

import com.googlecode.android_scripting.interpreter.InterpreterConfiguration;
import com.googlecode.android_scripting.trigger.TriggerRepository;

public class BaseApplication extends Application {

  private final TaskQueue mTaskQueue = new TaskQueue(this);

  protected TriggerRepository mTriggerRepository;

  protected InterpreterConfiguration mConfiguration;

  public TaskQueue getTaskQueue() {
    return mTaskQueue;
  }

  public TriggerRepository getTriggerRepository() {
    return mTriggerRepository;
  }

  @Override
  public void onCreate() {
    mTriggerRepository = new TriggerRepository(this);
    mConfiguration = new InterpreterConfiguration(this);
    mConfiguration.startDiscovering();
  }

  public InterpreterConfiguration getInterpreterConfiguration() {
    return mConfiguration;
  }
}
