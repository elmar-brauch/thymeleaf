package de.bsi.thymeleaf;

import java.io.Serializable;

/**
 * This record represents the model.
 * Instead of record a simple data class (POJO) could have been used.
 */
public record Item(String id, String name) implements Serializable {}
