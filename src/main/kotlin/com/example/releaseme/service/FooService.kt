package com.example.releaseme.service

import com.example.releaseme.domain.Foo
import com.example.releaseme.persistence.FooRepository
import org.springframework.stereotype.Service

@Service
class FooService(
    private val fooRepository: FooRepository,
) {
    fun findAll(): List<Foo> = fooRepository.findAll().toList()
    fun save(foo: Foo): Foo = fooRepository.save(foo)
}
