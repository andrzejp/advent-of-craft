package blog;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ArticleTests {

    public final Article ARTICLE = new Article(
            "Lorem Ipsum",
            "consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore"
    );
    private final LocalDate TODAY = LocalDate.of(2023, 12, 4);

    @Test
    void should_add_a_comment_with_the_given_text() throws CommentAlreadyExistException {
        var text = "Amazing article !!!";

        ARTICLE.addComment(text, "Pablo Escobar", TODAY);

        assertThat(ARTICLE.getComments())
                .hasSize(1)
                .anyMatch(comment -> comment.text().equals(text));
    }

    @Test
    void should_add_a_comment_with_the_given_author() throws CommentAlreadyExistException {
        var author = "Pablo Escobar";

        ARTICLE.addComment("Amazing article !!!", author, TODAY);

        assertThat(ARTICLE.getComments())
                .hasSize(1)
                .anyMatch(comment -> comment.author().equals(author));
    }

    @Test
    void should_add_a_comment_with_the_date_of_the_day() throws CommentAlreadyExistException {
        ARTICLE.addComment("Amazing article !!!", "Pablo Escobar", TODAY);

        assertThat(ARTICLE.getComments())
                .hasSize(1)
                .anyMatch(comment -> comment.creationDate().equals(TODAY));
    }

    @Test
    void should_throw_an_exception_when_adding_existing_comment() throws CommentAlreadyExistException {
        ARTICLE.addComment("Amazing article !!!", "Pablo Escobar", TODAY);

        assertThatThrownBy(() -> ARTICLE.addComment("Amazing article !!!", "Pablo Escobar", TODAY))
                .isInstanceOf(CommentAlreadyExistException.class);
    }
}
