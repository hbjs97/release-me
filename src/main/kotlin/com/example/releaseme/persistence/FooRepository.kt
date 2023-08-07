package com.example.releaseme.persistence

import com.example.releaseme.domain.Foo
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface FooRepository : CrudRepository<Foo, Long>
