package blog;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ArticleTests {

    private final LocalDate TODAY = LocalDate.of(2023, 12, 4);
    private Article article;

    @BeforeEach
    void setUp() {
        article = new Article(
                "Lorem Ipsum",
                "consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore"
        );
    }

    @Test
    void should_add_a_comment_with_the_given_text() throws CommentAlreadyExistException {
        var text = "Amazing article !!!";

        article.addComment(text, "Pablo Escobar", TODAY);

        assertThat(article.getComments())
                .hasSize(1)
                .anyMatch(comment -> comment.text().equals(text));
    }

    @Test
    void should_add_a_comment_with_the_given_author() throws CommentAlreadyExistException {
        var author = "Pablo Escobar";

        article.addComment("Amazing article !!!", author, TODAY);

        assertThat(article.getComments())
                .hasSize(1)
                .anyMatch(comment -> comment.author().equals(author));
    }

    @Test
    void should_add_a_comment_with_the_date_of_the_day() throws CommentAlreadyExistException {
        article.addComment("Amazing article !!!", "Pablo Escobar", TODAY);

        assertThat(article.getComments())
                .hasSize(1)
                .anyMatch(comment -> comment.creationDate().equals(TODAY));
    }

    @Test
    void should_throw_an_exception_when_adding_existing_comment() throws CommentAlreadyExistException {
        article.addComment("Amazing article !!!", "Pablo Escobar", TODAY);

        assertThatThrownBy(() -> article.addComment("Amazing article !!!", "Pablo Escobar", TODAY))
                .isInstanceOf(CommentAlreadyExistException.class);
    }
}
