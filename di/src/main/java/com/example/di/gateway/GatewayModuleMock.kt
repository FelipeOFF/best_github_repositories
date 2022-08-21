package com.example.di.gateway

import com.example.gateway.client.MockClient
import org.koin.dsl.module

val gatewayModuleMock = module {
    single { MockClient() }
    single { get<MockClient>().service }
}
