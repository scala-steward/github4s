/*
 * Copyright 2016-2020 47 Degrees, LLC. <http://www.47deg.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package github4s

import cats.instances.FutureInstances
import cats.{Eval, Id}
import github4s.free.interpreters.Interpreters

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

import implicits1._

trait InstancesAndInterpreters
    extends IdInstances
    with EvalInstances
    with FutureInstances
    with HttpRequestBuilderExtensionJVM {

  implicit val intInstanceIdScalaJ     = new Interpreters[Id]
  implicit val intInstanceEvalScalaJ   = new Interpreters[Eval]
  implicit val intInstanceFutureScalaJ = new Interpreters[Future]

}

object implicits extends InstancesAndInterpreters with FutureCaptureInstance
