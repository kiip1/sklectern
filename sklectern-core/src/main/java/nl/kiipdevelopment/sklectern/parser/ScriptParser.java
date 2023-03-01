package nl.kiipdevelopment.sklectern.parser;

import nl.kiipdevelopment.sklectern.ast.ASTNode;
import nl.kiipdevelopment.sklectern.ast.ASTStructureList;
import nl.kiipdevelopment.sklectern.lexer.ScriptLexer;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

/**
 * The parser builds an ast from tokens, with {@link ASTStructureList} as root.
 *
 * @see ASTNode
 */
@ApiStatus.Experimental
public interface ScriptParser {
    static @NotNull ScriptParser of(ScriptLexer lexer) {
        return new ScriptParserImpl(lexer);
    }

    @Contract("-> new")
    Instance instance();

    String script();

    int indentation();

    interface Instance {
        ASTNode parse();
    }
}
