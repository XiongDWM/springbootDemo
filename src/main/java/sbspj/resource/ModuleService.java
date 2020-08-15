package sbspj.resource;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

@Service(value="moduleService")
@Transactional
@Resource(name = "moduleRepo")
public class ModuleService {
	
}
