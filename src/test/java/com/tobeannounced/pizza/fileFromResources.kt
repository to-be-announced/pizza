package com.tobeannounced.pizza

import java.io.File

fun fileFromResources(name: String) = File((File::class as Any).javaClass.classLoader.getResource(name).file)