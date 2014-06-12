package net.memcached;

import java.io.Serializable;
import java.util.Date;

/**
 * TODO 此处填写 class 信息
 * 
 * @author krisjin
 * @date 2014-6-12下午2:33:24
 */

public class Message implements Serializable {

	/**
	 * Comment for <code>serialVersionUID</code>
	 */
	private static final long serialVersionUID = -8332548577393922707L;

	private long messageId;
	private Date postDate;
	private long userId;
	private String content;

	public long getMessageId() {
		return messageId;
	}

	public void setMessageId(long messageId) {
		this.messageId = messageId;
	}

	public Date getPostDate() {
		return postDate;
	}

	public void setPostDate(Date postDate) {
		this.postDate = postDate;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
