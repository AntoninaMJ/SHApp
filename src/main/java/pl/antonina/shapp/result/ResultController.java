package pl.antonina.shapp.result;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.antonina.shapp.user.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/users/{userId}/results")
public class ResultController {

    @Autowired
    private ResultService resultService;
    @Autowired
    private UserService userService;

    @GetMapping
    public List<ResultToGet> listOfResults(@PathVariable Long userId){
        return resultService.getAllResults(userId);
    }

    @GetMapping("/{resultId}")
    public ResultToGet getResult(@PathVariable Long resultId){
        return resultService.getResult(resultId);
    }

    @PostMapping
    public void addResult(@RequestBody ResultData resultData, @PathVariable Long userId ){
        resultService.addResult(resultData, userId);
    }

    @PutMapping("/{resultId}")
    public void updateResult(@RequestBody ResultData resultData, @PathVariable Long resultId){
        resultService.updateResult(resultData, resultId);
    }

    @DeleteMapping("{resultId}")
    public void deleteResult(@PathVariable Long resultId){
        resultService.deleteResult(resultId);
    }

}
