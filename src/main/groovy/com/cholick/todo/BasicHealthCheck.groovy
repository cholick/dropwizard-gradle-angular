package com.cholick.todo

import com.codahale.metrics.health.HealthCheck
import com.codahale.metrics.health.HealthCheck.Result

class BasicHealthCheck extends HealthCheck {

    @Override
    protected Result check() throws Exception {
        return Result.healthy()
    }

}
