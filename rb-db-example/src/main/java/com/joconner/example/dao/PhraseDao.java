package com.joconner.example.dao;

import com.joconner.example.model.Phrase;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by John O'Conner on 10/13/14.
 */
public class PhraseDao {

    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    protected PhraseDao() {

    }

    public PhraseDao(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<Phrase> findBy(Locale language) {
        List<Phrase> phraseList = new ArrayList<>();
        RowMapper<Phrase> rowMapper = new PhraseRowMapper();

        String sql = String.format("SELECT * FROM phrase WHERE language = %s", language.toString());
        try {
            phraseList =  jdbcTemplate.query(sql, rowMapper);

        } catch(DataAccessException ex) {
            // just return the empty list already created
        }
        return phraseList;
    }


    private class PhraseRowMapper implements RowMapper<Phrase> {


        @Override
        public Phrase mapRow(ResultSet resultSet, int i) throws SQLException {
            Phrase phrase = new Phrase();
            Long id = resultSet.getLong("id");
            String strLocale = resultSet.getString("language");
            String key = resultSet.getString("key");
            String value = resultSet.getString("phrase");
            phrase.setId(id);
            phrase.setLanguage(Locale.forLanguageTag(strLocale));
            phrase.setKey(key);
            phrase.setPhrase(value);
            return phrase;
        }
    }
}
