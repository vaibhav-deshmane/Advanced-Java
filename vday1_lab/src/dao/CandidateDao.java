package dao;

import java.sql.SQLException;
import java.util.List;

import pojo.Candidates;

public interface CandidateDao {
List<Candidates> getAllCandidate() throws SQLException;

String updateVotes(int id)throws SQLException;

}
