package ru.croc.course.database.init;

import ru.croc.course.database.init.script.AbstractScriptDatabaseInitializer;
import ru.croc.course.database.init.script.ScriptType;

import java.util.List;

public class DatabaseInitializer {

    private final List<AbstractScriptDatabaseInitializer> scriptDatabaseInitializers;

    public DatabaseInitializer(List<AbstractScriptDatabaseInitializer> scriptDatabaseInitializers) {
        this.scriptDatabaseInitializers = scriptDatabaseInitializers;
        initializeDatabase();
    }

    public void initializeDatabase() {
        applySchemaScripts();
        applyDataScripts();
    }

    private void applySchemaScripts() {
        scriptDatabaseInitializers.stream()
                .filter(script -> script.getScriptType().equals(ScriptType.SCHEMA))
                .forEach(AbstractScriptDatabaseInitializer::initializeDatabase);
    }

    private void applyDataScripts() {
        scriptDatabaseInitializers.stream()
                .filter(script -> script.getScriptType().equals(ScriptType.DATA))
                .forEach(AbstractScriptDatabaseInitializer::initializeDatabase);
    }


}
