package com.rubincomputers.vote_lunch;

import com.rubincomputers.vote_lunch.web.json.JsonUtil;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultMatcher;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Factory for creating test matchers.
 * <p>
 * Comparing actual and expected objects via AssertJ
 */
public class MatcherFactory {
    public static <T> Matcher<T> usingIgnoringFieldsComparator(Class<T> clazz, String... fieldsToIgnore) {
        return new Matcher<>(clazz, fieldsToIgnore, new String[]{""});
    }

    public static <T> Matcher<T> usingOnlyFieldsComparator(Class<T> clazz, String... fieldsToCompare) {
        return new Matcher<>(clazz,new String[]{""}, fieldsToCompare);
    }

    public static class Matcher<T> {
        private final Class<T> clazz;
        private final String[] fieldsToIgnore;
        private final String[] fieldsToCompare;

        private Matcher(Class<T> clazz, String[] fieldsToIgnore, String[] fieldsToCompare) {
            this.clazz = clazz;
            this.fieldsToIgnore = fieldsToIgnore;
            this.fieldsToCompare = fieldsToCompare;
        }

        public void assertMatch(T actual, T expected) {
            //assertThat(actual).usingRecursiveComparison().ignoringFields(fieldsToIgnore).isEqualTo(expected);
            assertThat(actual).usingRecursiveComparison().ignoringFields(fieldsToIgnore).comparingOnlyFields(fieldsToCompare).isEqualTo(expected);
        }

        @SafeVarargs
        public final void assertMatch(Iterable<T> actual, T... expected) {
            assertMatch(actual, Arrays.asList(expected));
        }

        public void assertMatch(Iterable<T> actual, Iterable<T> expected) {
            assertThat(actual).usingRecursiveFieldByFieldElementComparatorIgnoringFields(fieldsToIgnore).isEqualTo(expected);
        }

        public ResultMatcher contentJson(T expected) {
            return result -> assertMatch(JsonUtil.readValue(getContent(result), clazz), expected);
        }

        @SafeVarargs
        public final ResultMatcher contentJson(T... expected) {
            return contentJson(List.of(expected));
        }

        public ResultMatcher contentJson(Iterable<T> expected) {
            return result -> assertMatch(JsonUtil.readValues(getContent(result), clazz), expected);
        }

        public T readFromJson(ResultActions action) throws UnsupportedEncodingException {
            return JsonUtil.readValue(getContent(action.andReturn()), clazz);
        }

        private static String getContent(MvcResult result) throws UnsupportedEncodingException {
            return result.getResponse().getContentAsString();
        }
    }
}
