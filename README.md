更详细的说明：https://blog.csdn.net/sinat_42483341/article/details/99422163

# SORM0.8
由SORMSourceCode简化而来。删除了其中的测试用例，以及根据数据库表生成的java文件。使用时可重新生成。

一个简单的手写SORM框架，Java+MySQL，增删改查，根据表信息自动生成JavaBean。

（打包前）完整源代码：https://github.com/HanquanHq/SORMSourceCode

使用时，需要配置src下的db.properties文件，改成自己的数据库名称、路径。配置示例：

```
driver=com.mysql.cj.jdbc.Driver                               //数据库驱动
url=jdbc\:mysql\://localhost\:3306/sorm?serverTimezone=UTC    //数据库url
user=root                                                     //用户名
pwd=123456                                                    //密码
usingDB=mysql                                                 //mysq（能用）还是oracle（未测试）
srcPath=C:/Users/Bug/eclipse-workspace3/SORMSourceCode/src    //项目路径 用于根据数据库表名称生成javabrean
poPackage=com.bjsxt.po                                        //自动生成的javabean保存的包（若不存在，则自动创建）
queryClass=com.bjsxt.sorm.core.MySqlQuery                     //执行查询的类名称（不一定是mysql，可能是其他数据库，其他数据库需要自己实现类）
poolMinSize=10                                                //连接池的最小连接数
poolMaxSize=100                                               //连接池的最大连接数
```

#### 注意
1. 在src下建立db.properties，填写相关内容。
2. 第一次使用时，先运行JavaFileUtils.java，根据数据库表信息生成java文件，才能正常做一些测试。
3. 每张表目前仅支持一个主键。不能处理多个主键的情况。
4. po尽量使用包装类，不要使用基本数据类型。

几乎每个.java文件都有自己的main测试方法，文件名见名知意，比如MySQLQuery是用来执行SQL语句的。就不多解释啦。



#### 使用方式Demo

（1）创建项目，添加两个要用的jar包，按照自己的数据库修改properties信息
![在这里插入图片描述](https://img-blog.csdnimg.cn/2019081409545817.png)

（2）手动运行一下`TableContext.updateJavaPOFile();`，自动生成po类

```java
package cn.hanquan.test;

import com.bjsxt.sorm.core.TableContext;

public class Test {
	public static void main(String[] args) {
		// 首先通过这个方法生成po类
		TableContext.updateJavaPOFile();
	}
}
```

#### 增删改查
```java
package cn.hanquan.test;

import java.util.ArrayList;
import java.util.List;

import com.bjsxt.po.Emp;
import com.bjsxt.sorm.core.Query;
import com.bjsxt.sorm.core.QueryFactory;
import com.bjsxt.sorm.core.TableContext;

@SuppressWarnings("all")
public class Test {
	public static void main(String[] args) {
		// 首先通过这个方法生成po类
		TableContext.updateJavaPOFile();

		//add01();
		//delete01();
		//update01();
		select02();
	}

	// 增
	public static void add01() {
		Emp e = new Emp();
		e.setAge(18);
		e.setEmpname("大萝卜");
		e.setSalary(500000);

		Query q = QueryFactory.createQuery();
		q.insert(e);
	}

	// 删
	public static void delete01() {
		Query q = QueryFactory.createQuery();
		Emp e = new Emp();
		e.setId(5);
		q.delete(e);
	}

	// 改
	public static void update01() {
		Query q = QueryFactory.createQuery();
		Emp e = new Emp();
		e.setId(11);
		e.setEmpname("参天大萝卜");
		q.update(e, new String[] { "empname" });
	}

	// 查
	public static void select01() {
		Query q = QueryFactory.createQuery();
		List<Emp> list = new ArrayList<Emp>();
		list = q.queryRows("select * from emp where age>? and salary>?", Emp.class, new Object[] { 20, 5000 });
		for (Emp e : list) {
			System.out.println(e.toString());
		}
	}
	
	public static void select02() {
		Query q = QueryFactory.createQuery();
		List<Emp> list = new ArrayList<Emp>();
		System.out.println(q.queryUniqueRow("select * from emp where id>?", Emp.class, new Object[] { 2 }));

	}
}
```
