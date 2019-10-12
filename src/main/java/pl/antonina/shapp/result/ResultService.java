package pl.antonina.shapp.result;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.antonina.shapp.user.User;
import pl.antonina.shapp.user.UserService;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class ResultService {

    @Autowired
    private ResultRepository resultRepository;
    @Autowired
    private UserService userService;

    public List<ResultToGet> getAllResults(Long userId) {
        return resultRepository.findByUserId(userId).stream()
                .map(this::mapResultToGet)
                .collect(Collectors.toList());
    }

    public ResultToGet getResult(Long resultId) {
        Result result = resultRepository.findById(resultId).orElseThrow(NoSuchElementException::new);
        return mapResultToGet(result);
    }

    public void addResult(ResultData resultData, Long userId) {
        Result result = new Result();
        result.setMood(resultData.getMood());
        result.setPressure(resultData.getPressure());
        User user = userService.getUser(userId);
        result.setUser(user);
        resultRepository.save(result);
    }

    public void updateResult(ResultData resultData, Long resultId) {
        Result result = resultRepository.getOne(resultId);
        result.setPressure(resultData.getPressure());
        result.setMood(resultData.getMood());
        resultRepository.save(result);
    }

    public void deleteResult(Long resultId) {
        resultRepository.deleteById(resultId);
    }

    private ResultToGet mapResultToGet(Result result) {
        ResultToGet resultToGet = new ResultToGet();
        resultToGet.setId(result.getId());
        resultToGet.setMood(result.getMood());
        resultToGet.setPressure(result.getPressure());
        return resultToGet;
    }
}
