package com.cholick.todo

import com.cholick.todo.resources.TodoResource
import io.dropwizard.Application
import io.dropwizard.setup.Bootstrap
import io.dropwizard.setup.Environment

class App extends Application<AppConfiguration> {

    public static void main(String[] args) throws Exception {
        new App().run(args)
    }

    @Override
    void initialize(Bootstrap<AppConfiguration> bootstrap) {}

    @Override
    void run(AppConfiguration configuration, Environment environment) throws Exception {
        environment.jersey().register(new TodoResource())
    }

}
