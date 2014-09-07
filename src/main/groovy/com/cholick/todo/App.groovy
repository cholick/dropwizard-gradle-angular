package com.cholick.todo

import com.cholick.todo.resources.TodoResource
import com.google.inject.Guice
import com.google.inject.Injector
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
        Injector injector = Guice.createInjector()

        environment.lifecycle().manage(injector.getInstance(Startup))

        environment.jersey().register(injector.getInstance(TodoResource))
    }

}
