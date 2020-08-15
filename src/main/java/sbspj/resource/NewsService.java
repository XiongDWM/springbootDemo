package sbspj.resource;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

@Service(value="newsService")
@Transactional
@Resource(name = "newsRepo")
public class NewsService {

}
