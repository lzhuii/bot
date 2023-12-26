package bot.service;

import com.alibaba.dashscope.aigc.generation.Generation;
import com.alibaba.dashscope.aigc.generation.GenerationResult;
import com.alibaba.dashscope.aigc.generation.models.QwenParam;
import com.alibaba.dashscope.common.Message;
import com.alibaba.dashscope.common.MessageManager;
import com.alibaba.dashscope.common.Role;
import com.alibaba.dashscope.exception.InputRequiredException;
import com.alibaba.dashscope.exception.NoApiKeyException;
import org.springframework.stereotype.Service;

/**
 * @author hui
 * @since 2023-12-26 09:59:12
 */
@Service
public class DashScopeService {
	public String chat(String input) {
		Generation gen = new Generation();
		MessageManager msgManager = new MessageManager(10);
		Message userMsg = Message.builder()
				.role(Role.USER.getValue())
				.content(input)
				.build();
		msgManager.add(userMsg);
		QwenParam param = QwenParam.builder()
				.model(Generation.Models.QWEN_PLUS)
				.messages(msgManager.get())
				.resultFormat(QwenParam.ResultFormat.MESSAGE)
				.topP(0.8)
				.enableSearch(true)
				.build();
		try {
			GenerationResult result = gen.call(param);
			return result.getOutput().getChoices().getFirst().getMessage().getContent();
		} catch (NoApiKeyException | InputRequiredException e) {
			throw new RuntimeException(e);
		}
	}
}
